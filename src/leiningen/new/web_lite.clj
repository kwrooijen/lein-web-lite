(ns leiningen.new.web-lite
  (:require [leiningen.new.templates :refer [renderer raw-resourcer name-to-path sanitize-ns ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "web-lite"))
(def raw (raw-resourcer "web-lite"))

(defn copy-file [file]
  [file (raw file)])

(defn render-file [file data]
  [file (render file data)])

(defn files-src [data]
  [["src/{{sanitized}}/main.clj" (render "src/web_lite/main.clj" data)]])

(defn files-root [data]
  [[".gitignore" (raw "gitignore")]
   (render-file "README.md" data)
   (render-file "project.clj" data)])

(defn web-lite
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (main/info "Generating a new web-lite project.")
    (apply ->files data
           (concat
            (files-root data)
            (files-src data)))))
