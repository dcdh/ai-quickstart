# embedded

Question :
Réponds-moi en une seule phrase. Quel est le nom de l'héroïne du livre "la philosophie dans le boudoir" du marquis de Sade ?

## Sans ingestion

### log-requests

```json
{
  "model" : "llama3.2:latest",
  "messages" : [ {
    "role" : "user",
    "content" : "Réponds-moi en une seule phrase. Quel est le nom de l'héroïne du livre \"la philosophie dans le boudoir\" du marquis de Sade ?"
  } ],
  "options" : {
    "temperature" : 0.0,
    "top_k" : 40,
    "top_p" : 0.9
  },
  "stream" : false
}
```

### log-responses

```json
{
  "model" : "llama3.2:latest",
  "created_at" : "2025-01-18T21:42:30.879176268Z",
  "message" : {
    "role" : "assistant",
    "content" : "L'héroïne du livre \"la philosophie dans le boudoir\" du marquis de Sade s'appelle Justine, une jeune femme innocente et pure qui est confrontée à des expériences sexuelles et morales dévastatrices."
  },
  "done_reason" : "stop",
  "done" : true,
  "total_duration" : 9279406381,
  "load_duration" : 7381552909,
  "prompt_eval_count" : 65,
  "prompt_eval_duration" : 529000000,
  "eval_count" : 57,
  "eval_duration" : 1367000000
}
```


## nomic-embed-text (default)

```
2025-01-18 22:45:21,267 INFO  [org.acm.IngestorService] (executor-thread-1) Ingestion 'philosophie dans le boudoir' started
2025-01-18 22:48:35,370 INFO  [org.acm.IngestorService] (executor-thread-1) Ingestion 'philosophie dans le boudoir' ended
```

```sql
SELECT COUNT(*) FROM embeddings;
-- 1083
```

### log-requests

```json
{
  "model" : "llama3.2:latest",
  "messages" : [ {
    "role" : "user",
    "content" : "Réponds-moi en une seule phrase. Quel est le nom de l'héroïne du livre \"la philosophie dans le boudoir\" du marquis de Sade ?\n\nAnswer using the following information:\nLa Philosophie dans le boudoir Chapitre V\n\npas faits pour nous.\nD : Allons, mademoiselle.\nE , rougissant : Oh, ciel ! je suis d’une honte !\nD : Éloignez de vous ce sentiment pusillanime ; toutes nos\n\nM  SA : Non, non, Dolmancé, levez-vous ; songez que\nc’est le prix de vos travaux, et que je ne puis vous le livrer qu’après que\nvous l’aurez mérité.\n\nD : Soit, mais pour mieux convaincre Eugénie de tout ce\nque nous allons lui débiter sur le plaisir, quel inconvénient y aurait-il que\nvous la branliez devant moi, par exemple ?\n\nM  SA : Aucun, sans doute, et j’y vais procéder avec\n\n18\n\nLa Philosophie dans le boudoir Chapitre III\n\nM  SA : Je le crois de même.\nD : Eh bien, madame, je vais m’étendre sur ce canapé ; vous\n\nvous placerez près de moi, vous vous emparerez du sujet, et vous en expli-\n\n16\n\nLa Philosophie dans le boudoir Chapitre III\n\nquerez vous-même les propriétés à notre jeune élève. (Dolmancé se place\net M de Saint-Ange démontre.)"
  } ],
  "options" : {
    "temperature" : 0.0,
    "top_k" : 40,
    "top_p" : 0.9
  },
  "stream" : false
}
```

### log-responses

```json
{
  "model" : "llama3.2:latest",
  "created_at" : "2025-01-18T21:50:46.324035152Z",
  "message" : {
    "role" : "assistant",
    "content" : "L'héroïne du livre \"la philosophie dans le boudoir\" du marquis de Sade est Eugénie de Courval, également connue sous le nom d'Eugénie."
  },
  "done_reason" : "stop",
  "done" : true,
  "total_duration" : 12590296314,
  "load_duration" : 7429752621,
  "prompt_eval_count" : 592,
  "prompt_eval_duration" : 3813000000,
  "eval_count" : 44,
  "eval_duration" : 1346000000
}
```

> Et non ce n'est pas le bon nom ! Le véritable nom d'Eugénie est Eugénie de Mistival
> 
> Le nom n'a pas été fourni par le RAG

## llama3.2:latest

```
2025-01-18 22:57:37,486 INFO  [org.acm.IngestorService] (executor-thread-1) Ingestion 'philosophie dans le boudoir' started
2025-01-18 23:12:38,821 INFO  [org.acm.IngestorService] (executor-thread-1) Ingestion 'philosophie dans le boudoir' ended
```

```sql
SELECT COUNT(*) FROM embeddings;
-- 1083
```

### First run

#### log-requests

```json
{
  "model" : "llama3.2:latest",
  "messages" : [ {
    "role" : "user",
    "content" : "Réponds-moi en une seule phrase. Quel est le nom de l'héroïne du livre \"la philosophie dans le boudoir\" du marquis de Sade ?\n\nAnswer using the following information:\nporte les couleurs du crime ; voilà d’où vient la singulière réponse d’une\nfemme à imagination, qui foutait froidement avec son mari ;\n\nJamais un acte de possession ne peut être exercé sur un être libre ; il est\naussi injuste de posséder exclusivement une femme qu’il l’est de posséder\ndes esclaves ; tous les hommes sont nés libres, tous sont égaux en droit : ne\nperdons jamais de vue ces principes ; il ne peut donc être jamais donné,\nd’après cela, de droit légitime à un sexe de s’emparer exclusivement de\n\n127\n\nLa Philosophie dans le boudoir Chapitre VI\n\nelle, à un époux, ou qui n’a rien pour se faire aimer, ou qui a tout pour se\nfaire haïr ?"
  } ],
  "options" : {
    "temperature" : 0.0,
    "top_k" : 40,
    "top_p" : 0.9
  },
  "stream" : false
}
```

#### log-responses

```json
{
  "model" : "llama3.2:latest",
  "created_at" : "2025-01-18T22:15:29.261097695Z",
  "message" : {
    "role" : "assistant",
    "content" : "L'héroïne du livre \"la philosophie dans le boudoir\" du marquis de Sade est Isabelle de Merteuil."
  },
  "done_reason" : "stop",
  "done" : true,
  "total_duration" : 2551570027,
  "load_duration" : 22501471,
  "prompt_eval_count" : 261,
  "prompt_eval_duration" : 214000000,
  "eval_count" : 32,
  "eval_duration" : 2313000000
}
```




### Second run

J'ai dû faire un saut de ligne à la fin pour que la relance effectue une nouvelle requête.

#### log-requests

```json
{
  "model" : "llama3.2:latest",
  "messages" : [ {
    "role" : "user",
    "content" : "Réponds-moi en une seule phrase. Quel est le nom de l'héroïne du livre \"la philosophie dans le boudoir\" du marquis de Sade ?\n\n\nAnswer using the following information:\nmande maintenant si elle est bien juste, la loi qui ordonne à celui qui n’a\nrien de respecter celui qui a tout.Quels sont les éléments du pacte social ?\nNe consiste-t-il pas à céder un peu de sa liberté et de ses propriétés pour\nassurer et maintenir ce que l’on conserve de l’un et de l’autre ?\n\nlieu que le père l’a sollicité ; le père a donc voulu notre naissance, pendant\nque la mère n’a fait qu’y consentir.Quelle différence pour les sentiments !\n\nà cette férocité où certaines femmes sont naturellement entraînées, mais\ncela est faible et souvent beaucoup trop loin du besoin qu’elles ont de\nfaire pis. Il y aurait, sans doute, d’autres moyens par lesquels une femme,\nà la fois sensible et féroce, pourrait calmer ses fougueuses passions, mais\nils sont dangereux, Eugénie, et je n’oserais jamais te les conseiller… Oh !\nciel ! qu’avez-vous donc, cher ange ?…Madame, dans quel état voilà votre\nélève !…"
  } ],
  "options" : {
    "temperature" : 0.0,
    "top_k" : 40,
    "top_p" : 0.9
  },
  "stream" : false
}
```

#### log-responses

```json
{
  "model" : "llama3.2:latest",
  "created_at" : "2025-01-18T22:17:44.584357649Z",
  "message" : {
    "role" : "assistant",
    "content" : "Je suis désolé, mais l'héroïne du livre \"la philosophie dans le boudoir\" du marquis de Sade n'est pas explicitement mentionnée dans le texte fourni. Le texte semble être une citation ou un extrait d'un dialogue, mais il ne contient pas d'information sur l'héroïne du livre."
  },
  "done_reason" : "stop",
  "done" : true,
  "total_duration" : 4045679413,
  "load_duration" : 18856609,
  "prompt_eval_count" : 332,
  "prompt_eval_duration" : 254000000,
  "eval_count" : 77,
  "eval_duration" : 3772000000
}
```
