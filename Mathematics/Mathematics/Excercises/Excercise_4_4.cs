using System;
using System.Collections.Generic;
using System.Text;

namespace Mathematics.Excercises
{
    class Excercise_4_4 : IExcercise
    {
        public virtual void Start()
        {
            int n = 5;
            int k = 2;

            Console.WriteLine($"n = {n}, k = {k}");

            var result = CalculateBinomialkoeffizient(n, k);
            Console.WriteLine($"Ergebnis: {result}");
        }

        protected virtual int CalculateBinomialkoeffizient(int n, int k)
        {
            if(k == 0 || k == n)
            {
                return 1;
            }

            var withK = CalculateBinomialkoeffizient(n - 1, k - 1);
            var withoutK = CalculateBinomialkoeffizient(n - 1, k);

            return withK + withoutK;
        }
    }
}
