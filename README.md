This is my first budget project based on Java and Spring.

### Git - dobre praktyki
- przed mergem/pull/przełączeniem branchy drzewo robocze powinno być czyste
- usuwamy tylko branch na którym aktualnie się nie znajdujemy (nie podcina się nałęzi na której się siedzi:)
- po mergu zawsze zweryfikujmy czy wszyskto działa (ale tylko jeśli musimy rozwiązywac konflikty)
- zmergowany feature-branch można bezpiecznie usunąć

### Git - przydatne komendy
git status - co się dzieje w repo
git log - historia (q wychodzimy)
git log --graph - rysuje graf historii
git add . - dodaje do stage'a wszystkie zmienione/nowe pliki (wtedy można dopiero comitować)
git commit -m "co się zmienia" - zapis zmian do repozytorium
git branch -a - wyświetl wszystkie branche
git checkout nazwa_brancha - przełączenia na inny branch
git checkout -b nazwa_brancha - przełączenie na właśnie tworzony/nowy branch
git push nazwa-repo nazwa-brancha np. git push origin master - wypchnięcie zmian do nazwa-repo z brancha nazwa-brancha
git remote - pokaż zdalne repozytoria
git remote -v - jw. + adresy
git merge --abort - przerywa sesję mergowania

### MVC pattern
Controller  - prezentuje danych
Service     - logika aplikacji
Repository  - źródło danych

### REST
Create  - Post
Read    - Get
Update  - Patch (partial update), Put (whole update)
Delete  - Delete

### How to implement Rest
1. Define @RestController
2. Add @Service to controller (service has business logic:)) - use dependency injection
3. Add JpaRepository to Service class if access to data source is necessary - use dependency injection
4. Use correct Http methods
