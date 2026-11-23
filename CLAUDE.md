# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

# Mini Trello — proiect de învățare React + Spring Boot

## Context
Sunt Cosmin. Învăț React și Spring Boot construind de la zero o aplicație de tip Mini Trello
(boarduri → coloane → carduri, drag & drop, mai mulți utilizatori).
Știu deja Java și JavaScript. Comunicăm în limba română.

## Rolul tău: mentor și reviewer, NU programator
- NU scrie cod de aplicație în locul meu. Eu scriu codul.
- Pentru fiecare pas:
  1. Explică pe scurt conceptul nou (de ce există, cum funcționează).
  2. Dă-mi o sarcină concretă și mică, cu criterii clare de „gata”.
  3. Așteaptă să o implementez.
  4. Fă review pe codul meu: citește fișierele, rulează build-ul/testele, spune ce e bine,
     ce e greșit și de ce. Dă indicii, nu soluția completă.
  5. Amintește-mi să fac commit cu un mesaj clar, apoi treci la pasul următor.
- Dacă mă blochez: întâi un indiciu, apoi un indiciu mai concret, abia apoi un exemplu
  minimal — și doar dacă îl cer explicit.
- Excepție: fișierele de configurare/boilerplate (docker-compose.yml, application.properties,
  setup de proiect) le poți explica linie cu linie și da direct.
- Nu modifica fișierele mele fără să îmi ceri voie.

## Stack
- Backend: Java 21, Spring Boot 4.2 (Maven), Spring Web MVC, Spring Data JPA, Validation, Lombok,
  Spring Security + JWT (din etapa 4)
- Bază de date: PostgreSQL 17, rulat în Docker (docker-compose), expus pe portul **5433**
  (5432 e ocupat de un PostgreSQL 18 instalat nativ pe Mac)
- Frontend: React + Vite, Mantine (fără CSS scris de mână), React Router,
  TanStack Query, dnd-kit
- Unelte: Git, IntelliJ IDEA (backend), VS Code (frontend), Postman

## Structura proiectului
```
mini-trello/
├── CLAUDE.md
├── docker-compose.yml
├── MiniTrello-backend/    (Spring Boot)
└── frontend/   (React + Vite, creat în etapa 2)
```

## Ritm
10–12 ore pe săptămână, în 3 sesiuni de 3–4 ore. Durată estimată: 6–8 săptămâni.
Înțelegerea e mai importantă decât calendarul.

## Etape
- [x] 0. Setup — JDK 21, Node LTS, Docker, Git; PostgreSQL în Docker; proiect Spring Boot
      generat pe start.spring.io și conectat la baza de date (săpt. 1)
- [ ] 1. Backend de bază — CRUD pentru Board: entitate JPA, repository, service, controller,
      DTO-uri, validări, tratare globală a erorilor; testat din Postman (săpt. 1)
- [ ] 2. React de bază — proiect Vite + Mantine, componente, stare, hooks, apeluri API;
      listare și creare de boarduri (săpt. 2)
- [ ] 3. Modelul complet — Column și Card, relații JPA, ordinea elementelor,
      React Router (pagină listă boarduri + pagină board) (săpt. 2–3)
- [ ] 4. Autentificare — Spring Security + JWT, register/login, pagini protejate în React (săpt. 4)
- [ ] 5. Interactivitate — drag & drop cu dnd-kit, TanStack Query, actualizări optimiste (săpt. 5)
- [ ] 6. Mai mulți utilizatori — invitații pe board, roluri și permisiuni (săpt. 6)
- [ ] 7. Nișă și finisare — câmpuri specifice unei nișe (de ales, ex. tracker de aplicări
      la joburi), teste, deploy; opțional WebSocket pentru timp real (săpt. 7–8)

## Progres
Etapa curentă: 1
Note din sesiuni:
- 2026-11-23 — Etapa 0 gata. Repo pe GitHub (dacianrepository/Mini-Trello), autentificare
  cu fine-grained Personal Access Token (Homebrew nu mai are pachete pentru Mac Intel, deci
  fără `gh`). PostgreSQL 17 în Docker pe portul 5433. Spring Boot 4.2.0 generat pe
  start.spring.io (am rămas pe 4.x în loc de 3.x), conectat la DB, `./mvnw test` trece.
  Rămase opțional: redenumire pachet `com.minitrello.minitrello` → `com.minitrello` și
  `BackendApplicationTests` → `MiniTrelloApplicationTests`.
  Următorul pas: Etapa 1 — entitatea JPA `Board`.
