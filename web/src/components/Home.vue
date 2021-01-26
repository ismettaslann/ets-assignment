<template>
<div class="center">
  <b-card-group deck>
    <b-card
      title="Kayıt Ol"
      img-src="../assets/signup.jpg"
      img-alt="Image"
      img-top
      tag="article"
      style="max-width: 20rem;"
      class="mb-2"
    >
      <b-card-text>
        Kayıt olmak için "Kayıt Ol" butonuna tıklayınız.
      </b-card-text>

      <b-button href="/signup" type="submit" class="mr-2" variant="outline-dark">Kayıt Ol</b-button>
    </b-card>
  
    <b-card
      title="Kayıtları Listele"
      img-src="../assets/all-records.jpg"
      img-alt="Image"
      img-top
      tag="article"
      style="max-width: 20rem;"
      class="mb-2"
    >
      <b-card-text>
        Tüm kayıtları listelemek için "Tüm Kayıtları Listele" butonunu tıklayınız.
      </b-card-text>

      <b-button href="/all-records" type="submit" class="mr-2" variant="outline-dark">Tüm Kayıtları Listele</b-button>
    </b-card>
  </b-card-group>
</div>
</template>

<script>
export default {
 
}
</script>

<style scoped src="@/assets/styles/styles.css">
</style>