
cd src/main/resources/assets/spyglass-improvements/lang
list=("ar" "cl" "ec" "mx" "uy" "ve")
for elem in ar cl ec mx uy ve; do
    echo $elem
  cp es_es.json es_$elem.json
done