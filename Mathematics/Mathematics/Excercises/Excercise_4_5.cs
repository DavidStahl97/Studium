using System;
using System.Collections.Generic;
using System.Text;

namespace Mathematics.Excercises
{
    class Excercise_4_5 : Excercise_4_4
    {
        private long _counter;

        public override void Start()
        {
            _counter = 0;
            base.Start();

            Console.WriteLine($"Counter: {_counter}");
        }

        protected override int CalculateBinomialkoeffizient(int n, int k)
        {
            _counter++;
            return base.CalculateBinomialkoeffizient(n, k);
        }
    }
}
