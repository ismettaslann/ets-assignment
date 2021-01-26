<template>
    <div class="center-card">
      <b-card>
        <b-form v-on:submit.prevent="onSubmit" @reset="onReset"> 
          <b-form-group
            id="name-input-group"
            label-for="name"
            label="İsim:"  
            label-cols-lg="3"
            content-cols-lg="7"
            label-align="left">
            <b-form-input
              id="name"
              v-model="form.name"
              placeholder="Lütfen İsminizi Giriniz."
              v-on:keypress="isLetter($event)"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group 
            id="surname-input-group" 
            label="Soyisim:" 
            label-for="surname" 
            label-cols-lg="3" 
            content-cols-lg="7" 
            label-align="left">
            <b-form-input
              id="surname"
              v-model="form.surname"
              placeholder="Lütfen Soyisminizi Giriniz."
              v-on:keypress="isLetter($event)"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group 
            id="blood-type-input-group" 
            label="Kan Grubu:" 
            label-for="blood-type" 
            label-cols-lg="3" 
            content-cols-lg="7" 
            label-align="left">
            <b-form-select
              id="blood_type"
              v-model="form.blood_type"
              type="password"
              :options="bloodtypes"
              required
            ></b-form-select>
          </b-form-group>

          <b-form-group 
            id="phone-number-input-group-4" 
            label="Cep Telefonu:" 
            label-for="phone_number" 
            label-cols-lg="3" 
            content-cols-lg="7" 
            label-align="left">
            <b-form-input
              id="phone_number"
              v-model="form.phone_number"
              placeholder="Telefon Numaranızı Başında Sıfır Olmadan Giriniz"
              oninput="javascript: if (this.value.length >= this.maxLength) this.value = this.value.slice(0, this.maxLength);"
              type="number"
              maxLength="10"
              :state="phoneNumberState"
              aria-describedby="input-live-help input-live-feedback"
              required
            ></b-form-input>
            <b-form-invalid-feedback id="input-live-feedback">
              Lütfen geçerli bir telefon numarası giriniz.
            </b-form-invalid-feedback>
          </b-form-group>

          <b-form-group 
            id="address-input-group-4" 
            label="Adres:" 
            label-for="address" 
            label-cols-lg="3" 
            content-cols-lg="7" 
            label-align="left">
            <b-form-textarea
              id="address"
              v-model="form.address"
              placeholder="Lütfen Adresinizi Giriniz."
              required
            ></b-form-textarea>
          </b-form-group>

          <b-row>
            <b-col lg="3">
            </b-col>
            <b-col lg="7">
              <b-button type="submit" class="mr-2" variant="outline-dark" :disabled="inProgress">Sign Up</b-button>
              <b-button type="reset" variant="outline-info">Clear</b-button>
            </b-col>
           </b-row>
          
        </b-form>
      </b-card>
  </div>
</template>

<script>
import bloodtypes from '../common/bloodtypes.json'
import {post} from '../common/api-service'
import {INSER_NEW_RECORD_POSTFIX} from '../common/config'

export default {
    data() {
      return {
        form: {
          name:'',
          surname:'',
          blood_type:null,
          address:'',
          phone_number:'',
        },
        bloodtypes : bloodtypes,
        inProgress : false,
        errors : []
      }
    },
    computed : {
      phoneNumberState(){
        if(String(this.form.phone_number).length == 0){return null}
        else {return (String(this.form.phone_number).startsWith('5') && String(this.form.phone_number).length == 10 ) ? true : false;}
      }
    },
    methods: {
      isLetter(e) {
        let char = String.fromCharCode(e.keyCode); 
        if(/^[A-Za-z]+$/.test(char)) return true; 
        else e.preventDefault(); 
      },
      onReset(event) {
        event.preventDefault()
        // Reset our form values
        this.form.name = ''
        this.form.surname = ''
        this.form.blood_type = null
        this.form.address = ''
        this.form.phone_number = ''
        this.inProgress = false
      },
      onSubmit(){
        this.inProgress = true;
        post(INSER_NEW_RECORD_POSTFIX, this.form).then(response => {
          if(response.data.status){
            this.$bvModal.msgBoxOk("Kayıt başarıyla eklendi!", {
              title: 'Başarılı',
              size: 'sm',
              buttonSize: 'sm',
              okVariant: 'success',
              headerClass: 'p-2 border-bottom-0',
              footerClass: 'p-2 border-top-0',
              centered: true
            })
          }
          else{
            this.$bvModal.msgBoxOk(response.data.message, {
              title: 'Hata!',
              size: 'sm',
              buttonSize: 'sm',
              okVariant: 'danger',
              headerClass: 'p-2 border-bottom-0',
              footerClass: 'p-2 border-top-0',
              centered: true
            })
          }
        }).finally(() => this.inProgress = false)
      }
    }
}
</script>

<style scoped src="@/assets/styles/styles.css">
</style>
