using System;
using System.Collections.Generic;
using System.Text;

namespace Mathematics.Excercises
{
    class Excercise_4_9 : IExcercise
    {
        public void Start()
        {
            const int a = -9;
            const int b = 3;

            var mod = Modulo(a, b);

            Console.WriteLine($"{a} mod {b} = {mod}");
        }

        private int Modulo(int a, int b)
        {
            if(a * b >= 0)
            {
                return a % b;
            }

            int mod = a % b;
            if(mod == 0)
            {
                return mod;
            }

            return b - Math.Abs(mod);
        }
    }
}
