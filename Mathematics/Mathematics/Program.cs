using System;
using System.Linq;

namespace Mathematics
{
    class Program
    {
        static void Main(string[] args)
        {
            if(args.Length < 1)
            {
                Console.WriteLine("Spezify which Excercise should be started.");
                return;
            }

            var excercise = GetExcercise(args[0]);
            excercise.Start();
        }

        private static IExcercise GetExcercise(string argument)
        {
            var interfaceType = typeof(IExcercise);
            var type = AppDomain.CurrentDomain.GetAssemblies()
                .SelectMany(a => a.GetTypes())
                .Where(t => interfaceType.IsAssignableFrom(t) && !t.IsInterface)
                .SingleOrDefault(t => t.Name == argument);

            var instance = Activator.CreateInstance(type);

            return (IExcercise)instance;
        }
    }
}