using System;
using System.Linq;

namespace Mathematics
{
    class Program
    {
        static void Main(string[] args)
        {
            var type = typeof(IExcercise);
            var types = AppDomain.CurrentDomain.GetAssemblies()
                .SelectMany(s => s.GetTypes())
                .Where(p => type.IsAssignableFrom(p) && !p.IsInterface);
        }
    }
}
