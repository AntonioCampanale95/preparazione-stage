using System;
using System.Linq;
using StarwarsProject.Models;

class Program
{
    static void Main(string[] args)
    {
        using (var context = new AppDbContext())
        {
            // Recupera tutti i pianeti
            var pianeti = from p in context.Pianeti
                          select p;

            Console.WriteLine("Pianeti di Star Wars:");

            foreach (var pianeta in pianeti)
            {
                Console.WriteLine($"Nome: {pianeta.Nome}, Clima: {pianeta.Clima}, Terreno: {pianeta.Terreno}, Popolazione: {pianeta.Popolazione}");
            }

            // Recupera un pianeta in base al nome
            var pianetaTatooine = context.Pianeti
                .FirstOrDefault(p => p.Nome == "Tatooine");

            if (pianetaTatooine != null)
            {
                Console.WriteLine("\nPianeta Tatooine:");
                Console.WriteLine($"Nome: {pianetaTatooine.Nome}, Clima: {pianetaTatooine.Clima}, Terreno: {pianetaTatooine.Terreno}, Popolazione: {pianetaTatooine.Popolazione}");
            }

            // Aggiungi un nuovo pianeta
            var nuovoPianeta = new Pianeta
            {
                Nome = "Dagobah",
                Clima = "Umido",
                Terreno = "Paludoso",
                Popolazione = 0
            };

            context.Pianeti.Add(nuovoPianeta);
            context.SaveChanges(); // Salva le modifiche nel database
            Console.WriteLine("\nPianeta aggiunto: Dagobah");

            // Aggiorna un pianeta
            var pianetaCoruscant = context.Pianeti
                .FirstOrDefault(p => p.Nome == "Coruscant");

            if (pianetaCoruscant != null)
            {
                pianetaCoruscant.Popolazione = 2000000000;
                context.SaveChanges();
                Console.WriteLine("\nPianeta Coruscant aggiornato con nuova popolazione.");
            }

            // Elimina un pianeta
            var pianetaEndor = context.Pianeti
                .FirstOrDefault(p => p.Nome == "Endor");

            if (pianetaEndor != null)
            {
                context.Pianeti.Remove(pianetaEndor);
                context.SaveChanges();
                Console.WriteLine("\nPianeta Endor eliminato.");
            }
        }
    }
}
