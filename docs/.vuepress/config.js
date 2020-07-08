module.exports = {
  lang: 'zh-CN',
  title: 'Beluga',
  description: 'Beluga 快速开发脚手架',
  base: '/beluga/',
  plugins: ['vuepress-plugin-smooth-scroll', '@vuepress/active-header-links'],
  themeConfig: {
    sidebarDepth: 4,
    nav: require('./nav/zh'),
    sidebar: {
      '/guide/': getGuideSidebar()
    }
  },
  head: [
    ['link', { rel: 'icon', href: `/logo.png` }]
  ]
}

function getGuideSidebar() {
  return [
    {
      title: '指南',
      collapsable: false,
      children: [""]
    }
  ]
}
