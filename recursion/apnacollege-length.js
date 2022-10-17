let totalMinutes = 0;
let totalSeconds = 0;

document.querySelectorAll('.video-duration').forEach(node => {
    const text = node.textContent;
    if (text.length === 5) {
        const [minutes, seconds] = text.split(':');
        totalMinutes += parseInt(minutes);
        totalSeconds += parseInt(seconds);
    }
});

totalMinutes += parseInt(totalSeconds / 60);
totalSeconds = parseInt(totalSeconds % 60);

const hours = parseInt(totalMinutes / 60);
totalMinutes = parseInt(totalMinutes % 60);

console.log(
    String(hours).padStart(2, 0) +
        ':' +
        String(totalMinutes).padStart(2, 0) +
        ':' +
        String(totalSeconds).padStart(2, 0)
);
