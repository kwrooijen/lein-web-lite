(defproject web-lite/lein-template "0.0.2"
  :description "A Leiningen template for a bare bones simple webapp"
  :url "https://github.com/kwrooijen/lein-web-lite"
  :license {:name "MIT"}
  :eval-in-leiningen true
  :deploy-repositories [["clojars" {:url "https://clojars.org/repo"
                                    :username :env/clojars_user
                                    :password :env/clojars_pass
                                    :sign-releases false}]])
