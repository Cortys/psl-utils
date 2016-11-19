/*
 * This file is part of the PSL software.
 * Copyright 2011-2015 University of Maryland
 * Copyright 2013-2015 The Regents of the University of California
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.linqs.psl.utils.loading;

import java.util.*;

import org.linqs.psl.database.DataStore;
import org.linqs.psl.database.Partition;
import org.linqs.psl.database.loading.Inserter;
import org.linqs.psl.model.predicate.Predicate;
import org.linqs.psl.model.predicate.PredicateFactory;
import org.linqs.psl.model.predicate.StandardPredicate;

public class DataStoreInserterLookup implements InserterLookup {

	private final DataStore store;
	private final Partition partitionID;
	
	private Map<String,Inserter> buffer;
	
	public DataStoreInserterLookup(DataStore store, Partition pid) {
		this.store=store;
		this.partitionID=pid;
		buffer = new HashMap<String,Inserter>();
	}

	@Override
	public Inserter get(String predicateName) {
		Inserter ins = buffer.get(predicateName);
		if (ins==null) {
			PredicateFactory pf = PredicateFactory.getFactory();
			Predicate p = pf.getPredicate(predicateName);
			if (p != null) {
				if (p instanceof StandardPredicate) {
					ins = store.getInserter((StandardPredicate) p, partitionID);
					buffer.put(predicateName, ins);
				}
				else
					throw new IllegalStateException("Predicate '" + predicateName + "' is not a StandardPredicate.");
			}
			else
				throw new IllegalStateException("No predicate with name '" + predicateName + "' has been created.");
		}
		return ins;
	}
	
}
