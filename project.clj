(defproject charlize "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring "1.8.0"]
                 [hiccup "1.0.5"]]
  :profiles {:dev {:plugins [[lein-ring "0.12.5"]]}}
  :ring {:handler charlize.handler/handler}
  :repl-options {:init-ns charlize.core})
