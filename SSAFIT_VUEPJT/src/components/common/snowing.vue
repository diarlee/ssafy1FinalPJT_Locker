<template>
  <div class="headerLower-container">
    <!-- <img src="@/assets/img/winterRunning_image.jpg" alt=""> -->
    <canvas width="100%"></canvas>
  </div>
</template>

<script setup>
import { onMounted } from "vue";
onMounted(() => {
  var c = document.getElementsByTagName("canvas")[0];
  var b = document.body;
  var a = c.getContext("2d");
  let D = b.style;
  let f = window;
  D.margin = 0;
  D.overflow = "hidden";
  let i = f.innerWidth;
  let j = f.innerHeight;
  c.width = i;
  c.height = j;

  let k = Math;
  let l = k.random;
  let n = k.sin;
  let p = k.floor;
  let q = 20;
  let r = [];
  let s = k.PI;

  function t(d) {
    d.b = d.x = (l() * i - i * 0.5) * q;
    d.c = d.y = (l() * j - j * 0.2) * q;
    d.a = q;
    d.d = l();
  }
  for (var v = 0, w; v < 300; v++) {
    w = {};
    t(w);
    r.push(w);
  }
  setInterval(function () {
    a.fillStyle = "rgba(64,64,64,.8)";
    a.fillRect(0, 0, i, j);
    for (var d = 0; d < 300; d++) {
      var b = r[d],
        o = n(s) * 32 - 16,
        u = b.x / b.a,
        e = u + i / 2 - o,
        g = (o = b.y / b.a),
        m = l() * 360,
        x = b.a > q - 5 ? (q - b.a) / 5 : 1,
        h = q - b.a - 4;
      a.fillStyle = "hsla(" + p(m) + ",50%,95%," + x + ")";
      a.beginPath();
      if (b.a < q - 6) {
        a.save();
        a.translate(e, g);
        a.rotate(b.d * (d % 2 ? 1 : -1) * ((d % 3) / 2 + 0.1));
        g = 0;
        e = h / ((d % 4) + 2);
        for (m = h / ((d % 3) + 1); g < 6; g++) {
          a.lineTo(-e, m);
          a.lineTo(0, h);
          a.lineTo(e, m);
          a.lineTo(0, 0);
          a.rotate(k.PI / 3);
        }
        a.fill();
        if (d % 2 == 0) {
          g = 0;
          for (e = h / ((d % 5) + 1); g < 6; g++) {
            a.beginPath();
            a.moveTo(0, h);
            a.lineTo(-e, h - e);
            a.lineTo(0, h - e);
            a.lineTo(e, h - e);
            a.fill();
            a.rotate(k.PI / 3);
          }
        }
        a.restore();
      } else {
        a.arc(e, g, (1 / b.a) * 5 + 1, 0, k.PI * 2, true);
        a.fill();
      }
      b.b = u;
      b.c = o;
      b.a -= 0.15;
      b.d += l() / 5;
      if (b.a < 0.15 || b.b < -i / 2 || b.b > i / 2 || b.c > j) t(b);
      s += k.PI / 2;
    }
  }, 25);
});
</script>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  font-weight: 300;
}

canvas {
  position: absolute;
  top: 50%;
  left: 0;
  width: 100%;
  height: 400px;
  margin-top: -200px;
  overflow: hidden;
}
</style>
