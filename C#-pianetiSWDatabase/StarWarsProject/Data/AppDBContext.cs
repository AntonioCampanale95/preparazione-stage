using Microsoft.EntityFrameworkCore;
using StarwarsProject.Models;

public class AppDbContext : DbContext
{
    public DbSet<Pianeta> Pianeti { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseMySQL("server=localhost;port=3306;database=starwars_db;user=root;password=antoniodev");

    }
}
