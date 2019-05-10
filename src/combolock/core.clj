(ns combolock.core)

(defn lock
  []
  (for [t1 (range 10)
        t2 (range 10)
        t3 (range 10)
        :when (and (not= t1 t2 t3)
                   (not= t1 t2)
                   (not= t2 t3)
                   (not= t3 t1))]
    [t1 t2 t3]))
