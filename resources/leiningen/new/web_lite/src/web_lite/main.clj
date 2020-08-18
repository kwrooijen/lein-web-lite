(ns {{ns-name}}.main
  (:gen-class)
  (:require
   [aleph.http :as http]
   [reitit.ring :as ring]
   [ring.middleware.defaults :refer [wrap-defaults]]))

;; Handlers

(defn home-handler [request]
  {:status 200
   :body "Hello world!"})

;; Routes and middleware

(def routes
  [["/" {:get {:handler home-handler}}]])

(def ring-opts
  {:data
   {:middleware
    [#(wrap-defaults % ring.middleware.defaults/api-defaults)]}})

(def app
  (ring/ring-handler
   (ring/router routes ring-opts)))

;; Web server

(defonce server (atom nil))

(defn start-server []
  (reset! server (http/start-server #'app {:port 3000})))

(defn stop-server []
  (when @server
    (.close ^java.io.Closeable @server)))

(defn restart-server []
  (stop-server)
  (start-server))

;; Application entrypoint

(defn -main [& args]
  (println "Starting webserver.")
  (start-server))
