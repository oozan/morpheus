(ns morpheus.db
  (:require [next.jdbc :as jdbc]))

(def db-spec {:dbtype "postgresql"
              :dbname "morpheus"
              :host "localhost"
              :port 5432
              :user "your_user"
              :password "your_password"})

(defn get-user [email]
  (jdbc/execute-one! db-spec ["SELECT * FROM users WHERE email = ?" email]))

(defn create-user [email password]
  (jdbc/execute! db-spec ["INSERT INTO users (email, password) VALUES (?, ?)" email password]))
