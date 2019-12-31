(defproject charlize "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring "1.8.0"]
                 [hiccup "1.0.5"]
                 [seancorfield/next.jdbc "1.0.13"]
                 [clojure.jdbc/clojure.jdbc-c3p0 "0.3.3"]
                 [postgresql/postgresql "9.3-1102.jdbc41"]]
  :profiles {:dev {:plugins [[lein-ring "0.12.5"]]}}
  :ring {:handler charlize.handler/handler}
  :repl-options {:init-ns charlize.core})
