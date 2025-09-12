// This file exports utility functions that can be reused across different scripts.

function logMessage(message) {
    console.log(`[LOG] ${message}`);
}

function formatDate(date) {
    return date.toISOString().split('T')[0];
}

module.exports = {
    logMessage,
    formatDate
};