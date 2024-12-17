// Mock de dados de avaliações e perguntas
const reviews = [
    { username: "Carlos", date: "2024-11-10", stars: 5, comment: "Excelente produto, entrega rápida!" },
    { username: "Maria", date: "2024-11-09", stars: 4, comment: "Bom, mas a embalagem chegou um pouco danificada." },
    { username: "Ana", date: "2024-11-08", stars: 3, comment: "Produto dentro do esperado, mas não impressiona." }
];

const questions = [
    { question: "Esse produto é original?", response: "Sim, produto 100% original com garantia." },
    { question: "Qual o prazo de entrega para São Paulo?", response: "Prazo de 3 a 5 dias úteis." },
    { question: "Posso devolver se não gostar?", response: "Sim, oferecemos devolução em até 30 dias." }
];

// Função para renderizar as avaliações
function renderReviews() {
    const reviewList = document.getElementById("review-list");
    reviews.forEach(review => {
        const reviewElement = document.createElement("div");
        reviewElement.classList.add("review");

        reviewElement.innerHTML = `
            <div class="username">${review.username} <span class="date">- ${review.date}</span></div>
            <div class="stars">${"★".repeat(review.stars)}${"☆".repeat(5 - review.stars)}</div>
            <p>${review.comment}</p>
        `;

        reviewList.appendChild(reviewElement);
    });
}

// Função para renderizar perguntas e respostas
function renderQuestions() {
    const qaList = document.getElementById("qa-list");
    qaList.innerHTML = ""; // Limpar antes de adicionar novos comentários

    questions.forEach(qa => {
        const qaElement = document.createElement("div");
        qaElement.classList.add("qa-item");

        qaElement.innerHTML = `
            <p class="question"><strong>Pergunta:</strong> ${qa.question}</p>
            <p class="response"><strong>Resposta:</strong> ${qa.response}</p>
        `;

        qaList.appendChild(qaElement);
    });
}

// Função para adicionar novo comentário
function addComment() {
    const newComment = document.getElementById("new-comment").value;
    if (newComment.trim() === "") {
        alert("Por favor, insira um comentário.");
        return;
    }

    // Adicionando nova pergunta (ou resposta) ao array
    questions.push({ question: newComment, response: "Resposta do vendedor será adicionada aqui." });

    // Atualizando a lista de perguntas e respostas
    renderQuestions();

    // Limpando o campo de texto
    document.getElementById("new-comment").value = "";
}

// Chamando as funções de renderização ao carregar a página
document.addEventListener("DOMContentLoaded", () => {
    renderReviews();
    renderQuestions();

    // Adicionando funcionalidade de envio de comentário
    document.getElementById("submit-comment").addEventListener("click", addComment);
});