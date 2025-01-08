(ns morpheus.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
            [compojure.core :refer [GET POST routes]]
            [compojure.route :as route]
            [morpheus.db :as db])) ; Ensure this namespace exists and includes the get-user function

(defn handler []
  (routes
    (GET "/api/message" []
         {:status 200
          :headers {"Content-Type" "application/json"}
          :body {:message "Hello from Morpheus backend!"}})
    (POST "/api/login" {body :body}
          (let [{:keys [email password]} body
                user (db/get-user email)]
            (if (and user (= password (:password user)))
              {:status 200 :body {:success true}}
              {:status 401 :body {:success false :message "Invalid credentials"}})))
    (route/not-found "Not Found")))

(defn -main [& args]
  (run-jetty (wrap-json-response (wrap-json-body (handler))) {:port 3001 :join? false}))
