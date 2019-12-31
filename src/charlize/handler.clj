(ns charlize.handler
  (:require [hiccup.core :as h]))

(defn hello [request]
  (h/html [:body
           [:h1 "Hi mom"]
           [:p "Well hello there!"]]))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (hello request)})