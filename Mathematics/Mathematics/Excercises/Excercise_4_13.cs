using System;
using System.Collections.Generic;
using System.Text;

namespace Mathematics.Excercises
{
    class Excercise_4_13 : IExcercise
    {
        public void Start()
        {
            const int a = 21;
            const int b = 14;

            int ggTRecursive = GGTRecursive(a, b);
            int ggtIterative = GGTIterative(a, b);

            Console.WriteLine($"Recursive: ggT({a}, {b}) = {ggTRecursive}");
            Console.WriteLine($"Recursive: ggT({a}, {b}) = {ggtIterative}");
        }

        private int GGTRecursive(int a, int b)
        {
            if(a % b == 0)
            {
                return Math.Abs(b);
            }

            return GGTRecursive(b, a % b);
        }

        private int GGTIterative(int a, int b)
        {
            while(a % b != 0)
            {
                int newB = a % b;
                a = b;
                b = newB;
            }

            return b;
        }
    }
}
