# Melawai Android V10 – Proyek GitHub Actions

Nama aplikasi: **Melawai**. Domain produksi: `https://melawai.datawebs.my.id`.

## Build APK (GitHub)
1. Buat repositori GitHub privat (direkomendasikan) dan unggah **isi** ZIP Android ini ke root repo (jangan unggah ZIP master cPanel).
2. Buka **Actions** → **APK Uji Melawai** → **Run workflow**, atau push ke branch `main`.
3. Setelah workflow sukses, unduh artefak `Melawai-APK-Uji-V10` dan ekstrak `app-debug.apk`.
4. Uji login admin, PJLP, PPPK, Kamera/Galeri, check-in/out, GPS di latar, dan unduhan.
5. **Untuk distribusi produksi**, APK harus ditandatangani dengan keystore rilis yang sama seperti aplikasi sebelumnya. Debug APK bukan versi produksi dan kemungkinan tidak bisa menimpa paket yang ditandatangani dengan kunci berbeda. Untuk update website, ganti `downloads/kelurahan-melawai.apk` dengan APK rilis yang sudah diuji.

Lokasi Android dapat diperlambat oleh penghemat baterai dan kebijakan perangkat. Notifikasi dan izin lokasi tidak dapat memaksa perangkat memantau ketika OS menghentikan layanan. iPhone menggunakan PWA Safari, **bukan** APK Android.
