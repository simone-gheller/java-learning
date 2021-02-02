#Learning Java

Questo documento vuole essere un punto di riferimento per il mio percorso di autoformazione riguardo java.

###Knowledge
######Manipolazione di stringhe
- Stringbuilder per costruire stringhe (es. new StringBuilder("test").reverse.charAt(1).toString)
- String.format/ Format.format per formattare le stringhe usando %modificatori (es. %4.1f). #indica la base numerica della cifra, 0 mette un padding di 0 davanti alla cifra, - allinea a sinistra.
- Formatter formatter = new Formatter(Writer), formatter.format("%d,num) per scrivere usando String.format direttamente nei files.
######Rappresentazione base di data/ora
- uso di Istant per rappresentare istanti di tempo e intervalli brevi.
- LocalDate per gestire date e orari locali ed eseguire operazioni aritmetiche con le date
- ZonedDateTime per memorizzare informazioni riguardo il fuso orario
######Interfacce
- uso di iterator per implementare usi differenti del foreach (es. foreach(CustomAttribute ca : customClassInstance){...} dove CustomAttribute è un attributo di CustomClass su cui è possibile avere un'iterazione come un array)
- Default come parola chiave di un metodo per implementare un metodo in un'interafaccia e che sia automaticamente ereditato dai figli
######Sottoclassi
- Nesting Types, sono public static class che possono essere istanziati al dì fuori della classe circostante
- Inner classe, sono classi visibili sono alla classe che le dichiara
- Anonymous classes, sono classi che generano tipi ad-hoc per 1-2 job soltanto, similmente alle lambda expression. Devono essere instanze di interfacce/classi da cui eridatno metodi da sovrascrivere (es. new Comparable <> {@Override public int compareTo() {...}}).
######Arrays
- Arrays.toString(myarr) offre una rappresentazione a stringa del contenuto dell'array myarr
- Arrays.copyOf(Object[] myarr, int length) crea un nuovo array usando il contenuto di myarr e length come lunghezza
- Arrays.sort , Arrays.stream, Arrays.binarySearch, Arrays.fill
######Collections
- Iterator al posto di foreach per fare loop su una collection
######List
- myList.sort() o myList.sort(MY_COMPARATOR) o myList.sort((a,b) -> ...) per ordinare una lista
- LinkedList è preferibile ad ArrayList quando ho a che fare con molte operazioni di add e remove
######Map
- Java 8 Enhancements: more methods to update and put data in the map. (es. getOrDefault, Compute) e **foreach(BiConsumer<K,V> lambda)**. ReplaceAll(BiFunction<K,V,X> lambda) dove X è il return type della lambda
######Streams
- Comparable<T> (CompareTo(T o)) vs Compare (Compare(T o1, T o2)) nel sorted
- Collector.toList per trasformare uno stream in una semplice lista. Collector.groupby simile all'analogo SQL raggruppa risultati (topic avanzato)
######Collections factories
- Per incapsulare meglio una struttura dati è corretto evitare di fornire un getter della referenza originale. Collection.unmodifiableList(listToClone) crea una view alla lista che permette di accedere ai contenuti in read ma no in write della lista originale
- Collections.emptyList() , Collections.emptyMap() ... sono in realtà constanti statiche che sono utili per rappresentare es una lsita vuota. Invece di ritornare new Arraylist() vuoto passo questo. Uso efficiente di memoria
- List.of(value1, value2, ...) Map.of(k, v, ...) costruttore per collection immutabile
######I/O
- int length = myInputStream.read() => valoreLetto=length, length = myInputStream.read(byte[] b) leggono un byte o un array b.length max di byte. length è il numero di byte letti effettivi.
- myOutputStream.write(byte b), myOutputStream.write(byte[] b, int off, int len) scrivono byte sullo stream, off e len sono opzionali.
- int length = myReader.read() => char valoreLetto = (char)length , length = reader.read(char[] b) leggono un char o un array di char
- myWriter.write(char c), myWriter.write(char[] c), myWriter(String s) scrivono sullo stream.
- Autoclosable interface: functional interface che espone il metodo close(). una classe che implementa questa interfaccia può usare il try with resources, ovvero try(InputStream in = new InputStream(...)) {...}. chiudere uno stream composto chiude anche gli stream "base" (es. chiudere ObjectOutputStream chiude anche OutputStream).
######java.nio package
- Path identifica una risorsa con il suo percorso.
- Paths è la classe statica che fornisce dei factory constructor per creare i Path come Paths.getPath("myUri). fornisce inoltre metodi factory per costruire input/output stream. Ogni path viene generato dal proprio filySystem di riferimento. se è il default fileSystem è sufficiente Paths.getPath(). per gli altri si usa myFileSystem.getPath() su istanza di tipo FyleSystem.
- per copiare/incollare/tagliare i file si usa Files che prende come argomento i Path delle risorse è dei metodi standard specificati tramite enum (es. StandardCopyOption.REPLACE_EXISTING).
- per creare un nuovo fileSystem (es. zip) si usa la classe statica FileSystems che espone metodi factory newFileSystem. occorre fornire una mappa di provider (topic avanzato)
######regex
- Pattern p = Pattern.compile("...") aumenta le prestazione compilando la regex.
- Matcher m = p.matcher("testo su cui valutare la regex") si usa in un loop così: while(matcher.find()) {matcher.group()}
######Java Runtime
- Properties class per rappresentare file con proprietà (di tipo testo con .properties o XML .xml). setProperty("nomeProp","valore") setta una proprietà. get("nomeProp") ritorna il valore o null o un valore default.
- Properties prop = new Properties(defaultProp) con defaultProp anch' esso di tipo properties associa dei valori di default a prop.
- Il classpath è il percorso dove Java va a cercare librerie e classi non contenuto nel JDK. si può specificare con variabile d' ambiente oppure a runtime col comando java -cp \root1;\root2 mainClass.
######Logging
- Logger logger = Logger.getLogger("myName"). logger.setHandler(myHandler); Handler myHandler = new FileHandler("/percorso",byte,nfiles); myHandler.setFormatter(new SimpleFormatter());
- handler.setLevel(Level.X); logger.setLevel(Level.Y); logger.log(Level.ALL, "msg")
######Multithreading
- Thread pools: ExecutorService ex = Executors.newFixedThreadPools(3); ex.submit(runnable); ex.shutdown(); ex.awaitTermination(); shutdown non permette di inserire nuovi task mentre awaitTermination come join() è un metodo bloccante che aspetta la fine dell' esecuzione di ogni thread.
- Callable<T> callable = new Callable() è un' interfaccia simile a runnable, questa garantisce l' invio di un risultato di tipo T al posto di return void. la ricezione del risultato è presa in carico da una variabile di tipo Future<T>.
- Future<T> future = ex.submit(callable); per ottenere il valore effettivo si chiama future.get().
######Reflection
- Class<?> myClass = Class.forName("string"); myClass = CustomClass.name; myClass = instance.getClass();
- da un oggetto di tipo Class posso tirare fuori los cope di visibilità della classe, gli attributi e i metodi. getDeclaredMethods()/Fields() tira fuori i metodi o i campi che sono dichiarati dentro la classec, non include metodi di classi padre o interfacce.
- Per costruire un oggetto di tipo myClass posso usare myClass.newInstance() se ha un costruttore che non accetta parametri. Altrimenti devo ricavare il costruttore. Constructor = myClass.getConstructor(Class<?> paramTypeDelCostruttoreCheVoglio); Object o = constructor.newInstance();
- posso invocare un metodo con Method met = myClass.getMethod("name"); met.invoke(params);
- Lookup lu = MethodHandles.lookup(). MethodType = MethodType.methodtype(returnType, argumentsType). MethodHandle mhandle = lookup.findVirtual/findConstructor(className, "methodName", methodtype). mhandle.invoke(args).
######Annotations
- ci sono annotazioni built-in come @Override, @SuppressWarnings, @Deprecated.
- annotazioni custom si creano come interfacce con @interface nella dichiarazione. Possono contenere un elemento che viene dichiarato come un metodo senza argomenti;
- @Target serve a specificare che l' annotazione creata si applica solo a certi ElementType.
- @Retention serve a stabilire l' ambiente di validità dell' annotazione (es. Class, Runtime: fino a class lo scope è compiler level).
- se un' annotazione ha un elemento di nome value, la classe che estende l' annotazione può usare @ann(mioValore) direttamente per specificare il valore dell' elemento.
- per usare il valore: myClass.getAnnotation(annotation).value/elementName; Retention MUST be RUNTIME.
######Serialization
- L'oggetto deve implementare l'interfaccia Serializable. è possibile implementare anche devi metodi writeObject e readObject entrambi PRIVATE VOID. questi verranno chiamati automaticamente con ois.readObject() o oos.writeObject(obj). è possibile specificare in questo modo comportamenti aggiuntivi.
- SerialVersionUID può essere usato per evitare casino di retrocompatibilità (se serializzo un oggetto e dopo un po' la classe di riferimento cambia, ho un eccezione). se stabilisco un serial number che non cambia non ho eccezioni. CI possono essere però conflitti logici, quindi sarebbe meglio sovrascrivere readObject e writeObject
######CompletionStage
- CompletableFuture<Void/T> cf = CompletableFuture.runasynch(runnable/supplier, pool).
- posso usare join per aspettare il completamento del task oppure complete(val). complete non è bloccante ma se ilt ask non termina al momento della chiamata, lo termina ed associa val come valore del task.
- esistono anche obtrudeValue e obtrudeException che a prescindere dallo stato del task associano un valore o lanciano un eccezione SEMPRE.
- Eccezioni possono essere gestite con exceptionally tra uno stage e un altro della pipeline. exceptionally(consumer).
- Handle(BiFunction) / WhenComplete(BiConsumer) hanno come parametri l'eccezione e il risultato normale, posso a questo punto fare un controllo if.
######Generics
- & operatore si risolve come l' intersezione di due tipi. utili per unire del codice che non è possibile altrimenti perché due tipi non hanno interfacce in comune public <T extends DataInput & Closable> void method(T param).
- <? super T> leggo dati. <? extends T> scrivo dati.
######Nulls
- NON ho controllo sui dati: null check sui parametri dei metodi, o quando ricevo i dati.
- HO controllo sui dati: null check quando creo i dati. non è necessario effettuare diversi controlli ripetitivi.
- Il check può essere effettuato con if con try/catch o con i metodi ausiliari della classe statica Objects (es. Objects.requireNotNull, Objects.isNull).
- Si può considerare se esplicitamente controllare l' eccezione (NullPointerException) oppure sopprimerla e gestirla in altro modo, oppure magari sostituire con oggetti default tipo liste vuote. Best practise: fare overload di metodi che accettano certi parametri a null con una versione senza quel param.
- Null Object Pattern: non è un pattern della GOF. essenzialmente può essere considerato come uno state o uno stretegy che implementa un comportamento NULLO. questo oggetto "nullo" deve essere usato come default per certi tipi di implementazioni (es. in una classe ho un attributo String name e un metodo toString che stampa una stringa complessa di cui name fa parte. se name è null ho un problema quindi del getter di name chiamo il null object).
- Optional<T>: è un wrapper di T che O contiene un oggetto di tipo T oppure non contiene niente. Best practise usare come return type di metodi che controllo, NON usare come parametro. Si crea con un factory method di Optional e si lavora con .filter .map, si finisce con .ifPresent .orElse





###Timestamps

######5/01/2021
- Creato questo documento
- Progress on Java Basics on Pluralsight
######07/01/2021
- Progress on Java Basics on Pluralsight
######08/01/2021
- Terminato Java Basics
- Iniziato Java Intermediate on Pluralsight
######11/01/2021
- Lavorato su I/O e String manipulation
- Progress on Java Intermediate on Pluralsight
######12/01/2021
- Lavorato su file properties e logs
- Progress on Java Intermediate on Pluralsight
######13/01/2021
- Lavorato su multithreading
- Progress on Java Intermediate on Pluralsight
######14/01/2021
- Lavorato su reflection
- Progress on Java Intermediate on Pluralsight
######15/01/2021
- Lavorato su Annotazioni e Serializzazione
- Progress on Java intermediate on PluralSight
######18/01/2021
- Fatto esperimenti su java.reflect per manipolare oggetti su db senza conoscere la struttura della classe;
- Progress on Java intermediate on PluralSight
######19/01/2021
- ORM con java.reflect 
- Progress on Java intermediate on PluralSight
######20/01/2021
- MethodHandles e Dependency Injection
- Progress on Java intermediate on PluralSight
######21/01/2021
- CompletableFuture
- Progress on Java intermediate on PluralSight
######22/01/2021
- CompletableFuture
- Progress on Java intermediate on PluralSight
######25/01/2021
- CompletableFuture e gestione di eccezioni
- Progress on Java intermediate on PluralSight
######27/01/2021
- Generics
- Progress on Java intermediate on PluralSight
######27/01/2021
- Null values
- Progress on Java intermediate on PluralSight
