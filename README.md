# IntentExplicit

Activitat 02 · Programació multimèdia i dispositius mòbils (2n DAM).

App Android (Java) amb dues activities comunicades mitjançant un **Intent explícit**:

- **MainActivity**: fitxa d'usuari (nom, cognoms, edat i matriculat amb `RadioGroup`). El botó *Mostrar Info* obre `Activity2` amb `startActivityForResult`.
- **Activity2**: mostra les dades en `TextView` no editables, un `CheckBox` per acceptar la política de confidencialitat i el botó *Salir*, que retorna `true`/`false` a la pantalla principal.
- **Persona** (extra): classe `Serializable` que viatja dins del `Bundle` dels extras.
