## ollama

```shell
curl http://localhost:11434/api/chat -d '{
  "model": "llama3.2:latest",
  "messages": [
    {
      "role": "user",
      "content" : "Réponds-moi en une seule phrase. Quel est le nom de l'\''héroïne du livre \"la philosophie dans le boudoir\" du marquis de Sade ?"
    }
  ],
  "options": {
    "temperature" : 0,
    "top_k" : 40,
    "top_p" : 0.9
  },
  "raw": true,
  "stream" : false
}'
```

Par défault format=json est défini. Comment passer outre ?
Comment rajouter raw=true

## pg

docker exec -it distracted_johnson bash

PGPASSWORD=quarkus psql -U quarkus quarkus

\dt

\d embeddings

SELECT * FROM embeddings;
