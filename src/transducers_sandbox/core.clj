(ns transducers-sandbox.core)

(defn older-than-age [age]
  (filter #(>= (:age %) age)))

(defn younger-than-age [age]
  (filter #(< (:age %) age)))

(defn between-ages [coll lower-bound upper-bound]
  (count (sequence (comp (older-than-age lower-bound)
                         (younger-than-age upper-bound))
                   coll)))
