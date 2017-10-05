(defproject org.linqs/psl-textsim "1.1.0-SNAPSHOT"
  :description "Text similarity extensions to the PSL software from the LINQS research group."
  :dependencies [[org.linqs/psl-core "2.1.0-SNAPSHOT"]
                 [org.ujmp/ujmp-complete "0.2.4"]
                 [log4j "1.2.17"]
                 [org.slf4j/slf4j-api "1.7.21"]
                 [org.slf4j/slf4j-log4j12 "1.7.21"]
                 [com.google.guava/guava "20.0"]
                 [org.apache.commons/commons-lang3 "3.5"]
                 [org.apache.commons/commons-collections4 "4.1"]
                 [de.mathnbits/mathnbitsSTL "1.0"]
                 [net.sourceforge.collections/collections-generic
                  "4.01"]
                 [com.wcohen/secondstring "20120620"]]

  :repositories {"psl-releases" "https://linqs-data.soe.ucsc.edu/maven/repositories/psl-releases"
                 "psl-thirdparty" "https://linqs-data.soe.ucsc.edu/maven/repositories/psl-thirdparty"}

  :java-source-paths ["src/main/java"])
