(ns combolock.core-test
  (:require [clojure.test :as t]
            [clojure.set :as set]
            [combolock.core :as c]))

(def bad-lock-numbers
  (set (for [t1 (range 10)
             t2 (range 10)
             t3 (range 10)
             :when (or (= t1 t2 t3)
                       (= t1 t2)
                       (= t2 t3)
                       (= t3 t1))]
         [t1 t2 t3])))

(def good-lock-numbers (set (c/lock)))

(t/deftest test-same-numbers
  (t/is (= true (empty? (set/intersection good-lock-numbers bad-lock-numbers)))))
