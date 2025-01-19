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
  "created_at" : "2025-01-19T09:18:07.655146426Z",
  "message" : {
    "role" : "assistant",
    "content" : "L'héroïne du livre \"la philosophie dans le boudoir\" du marquis de Sade est Eugénie de Courval, également connue sous le nom d'Eugénie."
  },
  "done_reason" : "stop",
  "done" : true,
  "total_duration" : 12562799103,
  "load_duration" : 7409968525,
  "prompt_eval_count" : 592,
  "prompt_eval_duration" : 3805000000,
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
  "created_at" : "2025-01-19T09:38:53.055298242Z",
  "message" : {
    "role" : "assistant",
    "content" : "L'héroïne du livre \"la philosophie dans le boudoir\" du marquis de Sade est Isabelle de Merteuil."
  },
  "done_reason" : "stop",
  "done" : true,
  "total_duration" : 2546863409,
  "load_duration" : 24392624,
  "prompt_eval_count" : 261,
  "prompt_eval_duration" : 213000000,
  "eval_count" : 32,
  "eval_duration" : 2308000000
}
```
