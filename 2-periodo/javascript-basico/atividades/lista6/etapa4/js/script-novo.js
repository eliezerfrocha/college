// Jogo da memória - versão final integrada em etapa4
(function(){
    const btnIniciar = document.getElementById('btnIniciar');
    const selDificuldade = document.getElementById('dificuldade');
    const tabuleiro = document.getElementById('tabuleiro');
    const mensagem = document.getElementById('mensagem');
    const timerEl = document.getElementById('timer');
    const tentativasEl = document.getElementById('tentativas');
    const acertosEl = document.getElementById('acertos');
    const aproveitamentoEl = document.getElementById('aproveitamento');

    let vetorCartas = [];
    for(let i=1;i<=27;i++) vetorCartas.push(i);

    let pares = 4;
    let deck = [];
    let firstCard = null, secondCard = null;
    let lockBoard = false;
    let tentativas = 0, acertos = 0;
    let timer = null, seconds = 0;

    function formatTime(s){
        const mm = String(Math.floor(s/60)).padStart(2,'0');
        const ss = String(s%60).padStart(2,'0');
        return `${mm}:${ss}`;
    }

    function startTimer(){
        seconds = 0; timerEl.textContent = formatTime(seconds);
        if(timer) clearInterval(timer);
        timer = setInterval(()=>{
            seconds++; timerEl.textContent = formatTime(seconds);
        },1000);
    }

    function stopTimer(){ if(timer) clearInterval(timer); timer = null; }

    function showMessage(msg, type='info'){
        mensagem.textContent = msg;
        setTimeout(()=>{ if(mensagem.textContent === msg) mensagem.textContent=''; },2000);
    }

    function pickRandomUnique(count){
        const chosen = [];
        const pool = [...vetorCartas];
        while(chosen.length < count && pool.length){
            const idx = Math.floor(Math.random()*pool.length);
            chosen.push(pool.splice(idx,1)[0]);
        }
        return chosen;
    }

    function shuffle(array){
        const newArray = [...array];
        for(let i=newArray.length-1;i>0;i--){
            const j = Math.floor(Math.random()*(i+1));
            [newArray[i],newArray[j]] = [newArray[j],newArray[i]];
        }
        return newArray;
    }

    function buildDeck(pairCount){
        const chosen = pickRandomUnique(pairCount);
        const d = [];
        chosen.forEach(n => { d.push(n,n); });
        return shuffle(d);
    }

    function clearBoard(){
        stopTimer();
        tabuleiro.innerHTML = '';
        firstCard = null; secondCard = null; lockBoard = false;
        tentativas = 0; acertos = 0; seconds = 0;
        tentativasEl.textContent = '0'; 
        acertosEl.textContent='0'; 
        aproveitamentoEl.textContent='0%'; 
        timerEl.textContent='00:00';
        mensagem.textContent = '';
    }

    function renderBoard(deckArr){
        tabuleiro.classList.remove('cols-4','cols-8','cols-12');
        if(pares === 4) tabuleiro.classList.add('cols-4');
        if(pares === 8) tabuleiro.classList.add('cols-8');
        if(pares === 12) tabuleiro.classList.add('cols-12');

        deckArr.forEach((num, idx) => {
            const card = document.createElement('div');
            card.className = 'card';
            card.dataset.number = num;
            card.dataset.index = idx;

            const inner = document.createElement('div'); 
            inner.className = 'card-inner';

            const front = document.createElement('div'); 
            front.className = 'card-face card-front';
            const img = document.createElement('img');
            img.src = `img/carta${num}.png`;
            img.alt = `carta ${num}`;
            front.appendChild(img);

            const back = document.createElement('div'); 
            back.className = 'card-face card-back';
            back.textContent = '?';

            inner.appendChild(front);
            inner.appendChild(back);
            card.appendChild(inner);

            // Começa virada (mostrando o verso)
            card.classList.add('flipped');
            
            card.addEventListener('click', onCardClick);
            tabuleiro.appendChild(card);
        });
    }

    function updateStats(){
        tentativasEl.textContent = tentativas;
        acertosEl.textContent = acertos;
        const percent = tentativas > 0 ? (acertos / tentativas) * 100 : 0;
        aproveitamentoEl.textContent = `${percent.toFixed(2)}%`;
    }

    function onCardClick(e){
        const card = e.currentTarget;
        if(lockBoard) return; // already two open
        if(card.classList.contains('matched')) return; // already matched
        if(card === firstCard) { 
            showMessage('Clique em outra carta diferente da primeira.'); 
            return; 
        }

        // Revelar carta (removendo classe flipped)
        card.classList.remove('flipped');

        if(!firstCard){
            firstCard = card;
            return;
        }

        // second card
        secondCard = card;
        lockBoard = true;
        tentativas++;
        updateStats();

        const n1 = firstCard.dataset.number;
        const n2 = secondCard.dataset.number;

        if(n1 === n2){
            // match
            firstCard.classList.remove('flipped');
            secondCard.classList.remove('flipped');
            firstCard.classList.add('matched');
            secondCard.classList.add('matched');
            acertos++;
            showMessage('Par correto!', 'success');
            resetTurn(true);
        } else {
            // not match -> flip back after 1s
            showMessage('Não é um par. Tente novamente.', 'error');
            setTimeout(()=>{
                firstCard.classList.add('flipped');
                secondCard.classList.add('flipped');
                resetTurn(false);
            },1000);
        }
    }

    function resetTurn(matched){
        updateStats();
        // check game end
        if(acertos === pares){
            stopTimer();
            const percent = tentativas > 0 ? (acertos / tentativas) * 100 : 100;
            showMessage(`Jogo finalizado! Aproveitamento: ${percent.toFixed(2)}%`);
            aproveitamentoEl.textContent = `${percent.toFixed(2)}%`;
            lockBoard = true; // prevent further clicks
            return;
        }

        // clear trackers
        firstCard = null; secondCard = null; lockBoard = false;
    }

    btnIniciar.addEventListener('click', ()=>{
        pares = Number(selDificuldade.value);
        clearBoard();
        deck = buildDeck(pares);
        renderBoard(deck);
        startTimer();
        showMessage('Jogo iniciado. Boa sorte!');
    });

    // expose for debugging in console (optional)
    window.__memoryGame = { buildDeck, shuffle };
})();