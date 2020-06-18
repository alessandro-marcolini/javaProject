# javaProject
**Progetto di programmazione ad oggetti AA: 2019/2020**

Il progetto consiste nella creazione di una REST API mediante l'utilizzo di SpringBoot. Nel particolare si è sviluppata una API che interagisce con l'API di Twitter riguardante i dati geografici. La documentazione dell'API in questione la si può trovare al seguente [link](https://developer.twitter.com/en/docs/geo/places-near-location/api-reference/get-geo-search).

# Specifiche
Le specifiche di progetto, in particolare, riguardano:
 * lo sviluppo di funzionalità di analisi dei dati Geo di Twitter analizzando parametri geometrici delle location su almeno 10 città italiane
 * la restituzione di statistiche sull'area del boundingBox (area e perimetro)
 
# Struttura del progetto
Organizzazione dei package: 

![StrutturaPackage](https://github.com/alessandro-marcolini/javaProject/blob/master/UML/StrutturaPackage.png)

![Controller](https://github.com/alessandro-marcolini/javaProject/blob/master/UML/ControllerClassDiagram.png)

![Model](https://github.com/alessandro-marcolini/javaProject/blob/master/UML/ModelClassDiagram.png)

![Service](https://github.com/alessandro-marcolini/javaProject/blob/master/UML/ServiceClassDiagram.png)

![Utils](https://github.com/alessandro-marcolini/javaProject/blob/master/UML/UtilsClassDiagram.png)

![Exception](https://github.com/alessandro-marcolini/javaProject/blob/master/UML/ExceptionClassDiagram.png)


# Prerequisiti
Per testare la API è sufficiente:
 * clonarla localmente tramite il comando `git clone https://github.com/alessandro-marcolini/javaProject/` da terminale.
 * Aprire il progetto nel vostro IDE (es: Eclipse) ed eseguirlo.
 * Effettuare richieste sulle varie rotte attraverso il browser o Postman

# Come effettuare richieste
Qui sotto è mostrato il diagramma UML dei casi d'uso:

![useCaseDiagram](https://github.com/alessandro-marcolini/javaProject/blob/master/UML/useCaseDiagram.png)

Come si vede dal diagramma, l'utente può effettuare tre richieste diverse:
Tipo richiesta | Rotta | Descrizione
---------------|-------|------------
GET | `/metadata` | Ottenere i metadati
GET | `/search/nomecittà` | Ottenere dati di una singola città
GET | `/data` | Ottenere dati su 10 città casuali
 
 ## La rotta `/metadata`
 Diagramma di sequenza:
 
 ![MetadataSequenceDiagram](https://github.com/alessandro-marcolini/javaProject/blob/master/UML/MetadataSequenceDiagram.png)
 
 ## La rotta `/search/nomecittà`
  Il **controller** esegue una chiamata mediante il metodo `getRecordFromParam`, che a sua volta invoca i metodi `getJsonFromUrl`, `stringCleaner` e `toRecord`. Il metodo `getJsonFromUrl` è responsabile della connessione con la API di Twitter. È stato necessario aggiungere l'eccezione ApiRateLimitExceededException in quanto la API di Twitter ha un numero limite di richieste per utente in un determinato intervallo di tempo. C'è quindi un controllo sul codice http della risposta, che se fosse uguale a 429 (Too many request) lancerà l'eccezione.
  Le eccezioni personalizzate sono gestite dalla classe **GlobalExceptionHandler**.
  Se invece la richiesta va a buon fine il json ottenuto viene passato come parametro al metodo `stringCleaner`, il quale si occupa di una manipolazione dello stesso. Quello che ne risulta viene passato al metodo `toRecord` che si occupa della deserializzazione del json. Qualora la richiesta alla API di Twitter non avesse prodotto risultati, si ritorna un'eccezione di tipo CityNotFoundException.
  Se invece la richiesta ha prodotto dei risulati, si ritorna il risultato sotto forma di json assieme alle statistiche di area e perimetro (come attributi).
  
  Diagramma di sequenza:
 
 ![getRecordSequenceDiagram](https://github.com/alessandro-marcolini/javaProject/blob/master/UML/getRecordSequenceDiagram.png)
 
  ## La rotta `/data`
  Per ottenere risultati sempre diversi, si sono creati due metodi: randomValues e randomCities. La concatenazione dei due dà come risultato un array di 10 città casuali, prese da un file interno al progetto chiamato "comuni.json".
  Per ottenere i risultati, si utilizza il precedente metodo (vedi [/data](https://github.com/alessandro-marcolini/javaProject#la-rotta-searchnomecitt%C3%A0)).
  
  Diagramma di sequenza:
 
 ![getResultsSequenceDiagram](https://github.com/alessandro-marcolini/javaProject/blob/master/UML/getResultsSequenceDiagram.png)
 
 _Attenzione: è facile ottenere l'errore "Limite di richieste superato" se si eseguono richieste alla rotta `/data` per più volte._
 
# Alcuni esempi di chiamata
 * http://localhost:8080/metadata
 * http://localhost:8080/search/Macerata
 * http://localhost:8080/data

# Autore
**Alessandro Marcolini**
