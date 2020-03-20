(ns clojure-katas.exponential
  (:require [clojure-katas.core :as core]))

(core/defproblem expt-linear
  "b^n = b*b^(n-1)
   b^0 = 1"
  [base index]
  (if (zero? index)
    1
    (* base (expt-linear base (dec index)))))

(core/defproblem expt-fast
  "b^n = (b^(n/2))^2 if n is even
   b^n = b*b^(n-1) if n is odd"
  [base index]
  (cond
    (= index 2) (* base base)
    (even? index) (expt-fast (expt-fast base (/ index 2)) 2)
    (odd? index) (* base (expt-fast base (dec index)))))
