# Jogo da Memória — Atividade (lista6)

Esta pasta contém a implementação das etapas do exercício "Jogo da Memória".

O que foi feito
- Implementei a versão final do jogo e coloquei os arquivos funcionais na pasta `etapa4/`.
- A implementação cobre: seleção de dificuldade (4/8/12 pares), embaralhar pares aleatórios, renderizar cartas usando as imagens em `etapa4/img/`, cronômetro, contagem de tentativas, contagem de acertos, cálculo de aproveitamento, mensagens rápidas e bloqueio de cliques extras.

Arquivos principais atualizados/novos
- `etapa4/index.html` — interface do jogo (novo / substituído)
- `etapa4/css/style.css` — estilos e animações de virar cartas
- `etapa4/js/script.js` — lógica do jogo (embaralhar, render, eventos, timer)

Imagens
- As imagens das cartas estão em `etapa4/img/carta1.png` ... `carta27.png`. O script usa esses caminhos: `img/cartaX.png`.

Como testar localmente
1. No VS Code, abra a pasta `lista6`.
2. Abra o arquivo `etapa4/index.html` no navegador. Duas opções:

   - Arrastar o arquivo `etapa4/index.html` para o navegador.

   - Usar uma extensão como Live Server no VS Code (recomendado): clique com o botão direito em `etapa4/index.html` e selecione "Open with Live Server".

3. Na página do jogo: escolha o nível (Fácil/Médio/Difícil) e clique em "Iniciar".
4. Clique nas cartas para revelar. As regras implementadas:
   - Apenas duas cartas podem estar viradas por vez.
   - Se forem iguais, ficam viradas até o fim do jogo.
   - Se forem diferentes, voltam ao verso após 1s.
   - Contador de tentativas e acertos atualiza conforme o jogador joga.
   - Ao fim do jogo, o cronômetro para e uma mensagem indica o aproveitamento.

Observações e próximos passos possíveis
- Se preferir, posso:
  - Substituir também os diretórios `etapa1`/`etapa2`/`etapa3` pela versão final (não fiz isso para preservar histórico das etapas).
  - Adicionar uma imagem de verso (`back.png`) e ajustar o CSS para usá-la.
  - Adicionar um modal de fim de jogo com estatísticas e botão de reiniciar.

Relato das alterações
- Modo rápido: os arquivos mencionados acima foram sobrescritos com a versão final do jogo.

Se testar e encontrar algum problema, cole aqui o console do navegador (F12) e descreva o comportamento; eu corrijo rapidamente.
