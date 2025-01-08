(defproject morpheus "0.1.0-SNAPSHOT"
  :description "Morpheus Backend with Clojure"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [ring "1.9.3"]
                 [ring/ring-json "0.5.1"]
                 [seancorfield/next.jdbc "1.2.772"]
[org.postgresql/postgresql "42.3.3"]
                 [compojure "1.6.2"]]
  :main morpheus.core)
