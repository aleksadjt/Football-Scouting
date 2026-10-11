# Football Scouting Management System

A client–server desktop app for scouts to manage clubs, write scouting reports and rate players.

**Stack:** Java 17 · Swing · TCP sockets · MySQL 8

## Features

| Area | What you can do |
|---|---|
| Login | Scouts log in; the server checks credentials |
| Clubs | Create, search, update and delete |
| Reports | Rate each player 1–10 and record goals and assists |
| Licenses | Assign UEFA A, UEFA B and FIFA A licenses to scouts |

## Architecture

```
Swing client (operation + object, TCP :1234) --> thread per client
  --> controller --> system operation --> generic DB broker --> MySQL
```

- **Template Method:** each of the 20 operations runs check → execute → commit or roll back
- **Generic DB broker:** one broker handles every entity through an abstract domain object
- **Transactions and prepared statements** on every query
- **Schema constraints:** foreign keys, `CHECK`s and unique keys

| Module | Contents |
|---|---|
| `Zajednicki` | Shared domain classes and enums |
| `Server` | Socket server, controller, system operations, DB broker |
| `Klijent` | Swing forms, form controllers, coordinator |

## Run

```bash
mysql -u root -p < db/schema.sql
```

1. Open the three projects in NetBeans and build `Zajednicki` first.
2. Run `server.ServerForma` and start the server.
3. Run one or more `klijent.Klijent` and log in as a scout.

DB credentials are in `Konekcija.java`.

## Glossary

The code is in Serbian: skaut = scout, klub = club, liga = league, igrač = player, izveštaj = report, ocena = rating, licenca = license, zajednički = shared (common).
