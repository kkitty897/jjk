function showSurprise() {
    // Hide text and blur background
    document.getElementById('content').style.opacity = '0';
    document.getElementById('background').classList.add('blur');

    // Show the cake image after a small delay
    setTimeout(() => {
        document.getElementById('surprise').style.display = 'block';
    }, 500);
}
