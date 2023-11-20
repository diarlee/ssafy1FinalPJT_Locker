<template>
  <footer>
    <div class="footer-container">
      <div class="footer">
        <div class="footer-text">
          <span class="christmas-tree">&#127876;</span>
          Merry Christmas and Happy Holidays!
        </div>
        <div class="footer-text">
          Designed with <span style="color: #e74c3c">&hearts;</span> by
          <a href="https://www.example.com" target="_blank">Your Name</a>
        </div>
      </div>
    </div>
  </footer>
</template>

<script setup></script>

<style scoped>
 .footer-container {
      margin: 0;
      padding: 0;
      font-family: Arial, sans-serif;
    }
    .footer {
      background-color: #2c3e50;
      color: #ffffff;
      padding: 20px;
      text-align: center;
      bottom: 0;
      width: 100%;
    }
    .footer-text {
      font-size: 18px;
      margin-bottom: 10px;
    }
    .footer-text a {
      color: #ffffff;
      text-decoration: none;
    }
    .christmas-tree {
      display: inline-block;
      font-size: 36px;
      margin-right: 10px;
    }</style>
