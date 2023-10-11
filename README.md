# `spring-la-mia-pizzeria-relazioni`

## Continuazione esercizio
Questo esercizio è la continuazione della repo `spring-la-mia-pizzeria-crud` 
> (continuazione `spring-la-mia-pizzeria-crud` con modifiche/commit effettuate/i fino al 11/10/23).
>
> In fondo al README di questa repo c'è il README della repo precedente

## Todo
> ATTENZIONE!!!
>
> E' necessario **continuare con l'esercizio delle pizze** ma su **NUOVA REPO**.
> 
> Si consiglia quindi di eliminare la cartella nascosta `.git` e di procedere nuovamente con la fase di `init` su **nuova repo**.

## Esercizio
Nuova importante funzionalità : le offerte speciali!

In alcuni momenti potremmo voler vendere le nostre pizze a un prezzo scontato.

Dobbiamo quindi predisporre tutto il codice necessario per poter **collegare un’offerta speciale a una pizza** (in una relazione *1 a molti*, cioè un’offerta speciale può essere collegata a una sola pizza, e una pizza può essere collegata a più offerte speciali).

L’offerta speciale avrà :
- `data di inizio`
- `data di fine`
- `titolo`

La pagina di dettaglio della *singola pizza* mostrerà *l’elenco delle offerte collegate* e avrà un bottone `Crea nuova offerta speciale` per aggiungerne una nuova.

Accanto ad ogni offerta speciale è previsto un bottone che mi porterà a una pagina per modificarla.

# README DELLA REPO PRECEDENTE

# `spring-la-mia-pizzeria-crud`

## Todo
## `Giorno 1 - index, layout, spring jpa`
Realizzare un gestionale per una pizzeria. 

Abbiamo bisogno di creare la prima pagina (`index`) dove mostriamo **tutte le pizze che prepariamo**.

Una **pizza** avrà le seguenti informazioni:
- `nome`
- `descrizione`
- `foto` (url)
- `prezzo`

Creiamo il `database`, `model`, `repository` e `service` per gestire le **CRUD** delle pizze.

Implementare inoltre il `CommandLineRunner` come visto a lezione per caricare alcuni **dati fake**.

Implementiamo  quindi il **controller** con il metodo `index` che restituisce una **view** per mostrare **l’elenco delle pizze caricate dal database**.

###ATTENZIONE

> L’elenco potrebbe essere vuoto
> In quel caso dobbiamo mostrare un messaggio che indichi all’utente che non ci sono pizze presenti nella nostra applicazione. 
> 
> Testare anche questa eventualita' commentando gli inserimenti nel `CommandLineRunner`.

Gestiamo i componenti riutilizzabili con i `fragments`.

## `Day 2 - Show + Filter`

Lo scopo di oggi è quello di mostrare i dettagli di una singola pizza.

Ogni pizza dell’elenco avrà quindi un pulsante che se cliccato ci porterà a una pagina che mostrerà i dettagli della pizza scelta.

Dobbiamo quindi inviare l’`id` come parametro dell’`URL`, recuperarlo nel metodo del `controller`, caricare i dati della **pizza ricercata** e passarli come `model`.

La `view` a quel punto li mostrerà all’utente con la grafica che preferiamo.

Nella pagina con l’elenco delle pizze aggiungiamo un campo di testo che se compilato filtrerà le pizze (**lato server**) aventi come `titolo` quello inserito dall’utente.

## `Day 3: create + validation`
Abbiamo la lista delle pizze, abbiamo i dettagli delle pizze...perché non realizzare la **pagina per la creazione di una nuova pizza**

Aggiungiamo quindi tutto il codice necessario per **mostrare il form per la creazione di una nuova pizza e per il salvataggio dei dati in tabella**.

Nella `index` creiamo ovviamente il bottone `Crea nuova pizza` che ci porta a questa nuova pagina creata.

Ricordiamoci che l’utente potrebbe sbagliare inserendo dei dati **non consistenti**, gestiamo quindi la validazione. Ad esempio verifichiamo che:
- i dati della pizza **siano tutti presenti**
- il campi di **testo non superino una certa lunghezza**
- il **prezzo abbia un valore valido** (prezzo maggiore di zero)

## Day 4: update + delete
Completiamo le pagine di gestione delle nostre pizze.

Abbiamo la pagina con la lista di tutte le pizze, quella con i dettagli della singola pizza, quella per crearla...cosa manca?

Dobbiamo realizzare :
- pagina di **modifica di una pizza**
- **cancellazione di una pizza** cliccando un pulsante presente nella grafica di ogni singolo prodotto mostrato nella lista in homepage

