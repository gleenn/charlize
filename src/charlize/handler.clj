(ns charlize.handler
  (:require [hiccup.core :as h]
            [next.jdbc :as jdbc]
            [jdbc.pool.c3p0 :as pool]))

;(def dbspec (pool/make-datasource-spec {:subprotocol "postgresql"
;                                        :subname "//localhost:5432/glenn"}))

(defn fetch-stuff []
  (let [dbspec (jdbc/get-datasource {:dbtype "postgresql" :dbname "glenn" :host "localhost" :port 5432})]
    (with-open [connection (jdbc/get-connection dbspec)]
      (jdbc/execute! connection ["create table if not exists users(id int primary key, name varchar(32), email varchar(255))"])
      ;(jdbc/execute! connection [...])
      ;(reduce my-fn init-value (jdbc/plan connection [...]))
      ;(jdbc/execute! connection [...])
      )))

(defn setup [request]
  (fetch-stuff)
  {:status  302
   :headers {"Location" "/"}})

(defn hello [request]
  (h/html [:body
           [:h1 "Hi mom"]
           [:p "Well hello there!"]
           [:p [:a {:href "/setup"} "Setup!"]]]))

(defn handler [request]
  (prn request)
  (condp = (:uri request)
    "/setup" (setup request)

    {:status  200
     :headers {"Content-Type" "text/html"}
     :body    (hello request)}))