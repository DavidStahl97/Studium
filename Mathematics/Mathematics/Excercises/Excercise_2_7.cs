using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Mathematics.Excercises
{
    class Excercise_2_7 : IExcercise
    {
        private readonly IList<int> _primes = new List<int> { 2, 3 };

        public void Start()
        {
            while(Condition(_primes) == false)
            {
                var nextPrime = GetNextPrime(_primes.Last());
                _primes.Add(nextPrime);
            }

            var firstValidNumber = CalculateNextNumber(_primes);
            var primeFactors = GetPrimeFactors(firstValidNumber);

            PrintResult(firstValidNumber, primeFactors);
        }

        private bool Condition(IEnumerable<int> primes)
        {
            var value = CalculateNextNumber(primes);
            return !IsPrime(value);
        }

        private static int CalculateNextNumber(IEnumerable<int> primes)
        {
            return primes.Aggregate((a, p) => a * p) + 1;
        }

        private static int GetNextPrime(int oldPrime)
        {
            if(oldPrime == 2)
            {
                return 3;
            }

            int nextNumber = oldPrime;
            do
            {
                nextNumber += 2;
            }
            while (!IsPrime(nextNumber));

            return nextNumber;
        }

        private static bool IsPrime(int number)
        {
            if(number % 2 == 0)
            {
                return false;
            }

            for(int i = 3; i <= number / 2; i += 2)
            {
                if(number % i == 0)
                {
                    return false;
                }
            }

            return true;
        }

        private static IEnumerable<int> GetPrimeFactors(int number)
        {
            var primeFactors = new List<int>();

            int factor = number;
            int prime = 2;
            while(factor != 0)
            {
                if(number % prime != 0)
                {
                    prime = GetNextPrime(prime);
                    continue;
                }

                factor /= prime;

                if (!primeFactors.Any(f => f == prime))
                {
                    primeFactors.Add(prime);
                }
            }

            return primeFactors;
        }

        private void PrintResult(int validNumber, IEnumerable<int> primes)
        {
            Console.WriteLine($"First valid number: { validNumber }");
            Console.WriteLine();

            var s = string.Empty;
            foreach(var prime in primes)
            {
                s += $"{ prime } * ";
            }

            s = s[0..^3];

            Console.WriteLine($"prime factors: {s}");
        }
    }
}