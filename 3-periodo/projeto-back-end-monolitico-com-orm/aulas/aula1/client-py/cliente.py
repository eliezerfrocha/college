
import requests

# GET
route = '/api/contato'
url = 'http://localhost:8080' + route

print("\n")
response = requests.get(url)
if (response.status_code == 200):
    print(f"GET ✅")
else: 
    print(f"GET ❌")

if response.status_code == 200:
    data = response.json()
    print("Json:")
    print(data)
    print("\n")

    print("Contato:")
    for cliente in data:
        print(f"Código: {cliente['codigo']}, Nome: {cliente['nome']}")
else:
    print(f"Erro ao acessar API 🫠")

print("\n")
