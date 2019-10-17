using System;
using System.Collections.Generic;
using System.Numerics;
using System.Text;

namespace Mathematics.Excercises
{
    class Excercise_3_9 : IExcercise
    {
        private const int _base = 2;
        private int _counter = 0;

        public void Start()
        {
            for(int i = 2; i < 16; i++)
            {
                Console.WriteLine($"{ _base }^{ i }");
                var potenz = BigInteger.Pow(_base, i);
                Calculate(potenz, _base);
                Console.WriteLine();

                Console.WriteLine($"{ _base }^{ i } - 1");
                potenz -= 1;
                Calculate(potenz, _base);
                Console.WriteLine();
            }
        }

        private void Calculate(BigInteger potenz, BigInteger baseValue)
        {
            var result = IterativeFunction(potenz, baseValue);
            Console.WriteLine($"Iterative Variant: \n Count: { _counter }, Result: { Convert(result) }");

            _counter = 0;
            result = DivideAndConquer(potenz, baseValue);
            Console.WriteLine($"Divide and Conquer: \n Count: { _counter }, Result: { Convert(result) }");
        }

        private BigInteger IterativeFunction(BigInteger potenz, BigInteger baseValue)
        {
            BigInteger value = 1;

            for(int i = 0; i < potenz; i++)
            {
                _counter++;
                value *= baseValue;
            }

            return value;
        }

        private BigInteger DivideAndConquer(BigInteger potenz, BigInteger value)
        {
            _counter++;

            if(potenz.IsZero)
            {
                return 1;
            }
            else if(potenz.IsEven)
            {
                var result = DivideAndConquer(potenz / 2, value);
                return result * result;
            }
            else
            {
                var result = DivideAndConquer(potenz - 1, value);
                return value * result;
            }
        }

        private static string Convert(BigInteger integer)
        {
            string s = integer.ToString();
            if (s.Length < 10)
            {
                return s;
            }

            string first = s.Substring(0, 3);
            string second = s.Substring(s.Length - 4, 3);

            return $"{first}...{second}";
        }
    }
}
