import re

try:
    from PIL import Image
except ImportError:
    import Image
import pytesseract

plain_text = pytesseract.image_to_string(Image.open('skills.png'))
splitted_text = plain_text.split("\n")

res = {}
prevKey = None

for word in splitted_text:
    searched_word = normalized_word = re.search('\w*\s\w+', word)
    if (searched_word == None):
        continue
    normalized_word = searched_word.group()
    isKey = normalized_word == normalized_word.upper()

    if (prevKey != None and not isKey):
        if (prevKey in res.keys()):
            res[prevKey].append(normalized_word)
        else:
            res[prevKey] = [normalized_word]

    if (prevKey != normalized_word and isKey):
        prevKey = normalized_word.tolower()

print(res)