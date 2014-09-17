(ns transducers-sandbox.core-spec
  (:require [speclj.core :refer :all]
            [transducers-sandbox.core :refer :all]))

(describe "transducers-sandbox.core"
  (with ages
    [{:age 10}
     {:age 11}
     {:age 18}
     {:age 19}
     {:age 20}
     {:age 21}
     {:age 22}])

  (context "/younger-than-age"
    (it "returns a transducer for items with age less than the input"
      (should= [{:age 10}]
               (iteration (younger-than-age 11) @ages))))

  (context "/older-than-age"
    (it "returns a transducer for items with age greater or equal to input"
      (should= [{:age 21} {:age 22}]
               (iteration (older-than-age 21) @ages))))

  (context "/between-ages"
    (it "returns the number of people between the ages of 18 and 21"
      (should= 3
               (between-ages @ages 18 21)))))
