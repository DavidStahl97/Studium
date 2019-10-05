using System;
using System.Collections.Generic;
using System.Text;

namespace Mathematics.Excercises
{
    class Excercise_4_4 : IExcercise
    {
        public void Start()
        {
            int n = 10;
            int k = 5;

            Console.WriteLine($"n = {n}, k = {k}");

            var result = CalculateBinomialkoeffizient(10, 5);
            Console.WriteLine($"Ergebnis: {result}");
        }

        private int CalculateBinomialkoeffizient(int n, int k)
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
