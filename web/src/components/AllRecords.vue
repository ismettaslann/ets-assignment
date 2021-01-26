<template>
  <div class="center-card">
    <b-card>
      <b-table striped hover 
        id="records-table"
        :items="items" 
        :fields="fields"       
        :per-page="perPage"
        :current-page="currentPage">
      </b-table>
      
      <b-pagination
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        aria-controls="records-table">
      </b-pagination>
    </b-card>
  </div>
</template>

<script>
import {get} from "../common/api-service";
import {GET_ALL_RECORDS_POSTFIX} from '../common/config'

export default {
  data() {
    return {
      perPage: 10,
      currentPage: 1,
      fields: [
          { key: 'name',        label: 'İsim', sortable: true},
          { key: 'surname',     label: 'Soyisim', sortable: true },
          { key: 'blood_type',  label: 'Kan Grubu', sortable: true },
          { key: 'phone_number', label: 'Telefon Numarası', sortable: true },
          { key: 'address',     label: 'Adres' }
        ],
      items: []
    }
  },
  created() {
    this.getRecords();
  },
  methods: {
    getRecords() {
      get(GET_ALL_RECORDS_POSTFIX).then(response => {
        this.items = response.data.records;
      })
    }
  },
  computed: {
      rows() {
        return this.items.length
      }
    }
}
</script>

<style>

</style>